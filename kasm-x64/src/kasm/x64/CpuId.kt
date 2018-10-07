package kasm.x64

import kasm.ExecutableBuffer
import kasm.Structure
import java.util.*

object CpuId {

    val supportsAvx512
        get() = CpuFeature.avx512Features.any {
            it in features
        }

    val supportsAvx get() = CpuFeature.AVX in features

    private val CPUID_MAP = mapOf(
            listOf(0x1, null) to mapOf(
                    GpRegister32.EDX to listOf(
                            CpuFeature.FPU,
                            CpuFeature.VME,
                            CpuFeature.DE,
                            CpuFeature.PSE,
                            CpuFeature.TSC,
                            CpuFeature.MSR,
                            CpuFeature.PAE,
                            CpuFeature.MCE,
                            CpuFeature.CX8,
                            CpuFeature.APIC,
                            CpuFeature.RESERVED,
                            CpuFeature.SEP,
                            CpuFeature.MTRR,
                            CpuFeature.PGE,
                            CpuFeature.MCA,
                            CpuFeature.CMOV,
                            CpuFeature.PAT,
                            CpuFeature.PSE36,
                            CpuFeature.PSN,
                            CpuFeature.CLFSH,
                            CpuFeature.RESERVED,
                            CpuFeature.DS,
                            CpuFeature.ACPI,
                            CpuFeature.MMX,
                            CpuFeature.FXSR,
                            CpuFeature.SSE,
                            CpuFeature.SSE2,
                            CpuFeature.SS,
                            CpuFeature.HTT,
                            CpuFeature.TM,
                            CpuFeature.IA64,
                            CpuFeature.PBE
                                              ),
                    GpRegister32.ECX to listOf(
                            CpuFeature.SSE3,
                            CpuFeature.PCLMULQDQ,
                            CpuFeature.DTES64,
                            CpuFeature.MONITOR,
                            CpuFeature.DS_CPL,
                            CpuFeature.VMX,
                            CpuFeature.SMX,
                            CpuFeature.EST,
                            CpuFeature.TM2,
                            CpuFeature.SSSE3,
                            CpuFeature.CNXT_ID,
                            CpuFeature.SDBG,
                            CpuFeature.FMA,
                            CpuFeature.CX16,
                            CpuFeature.XTPR,
                            CpuFeature.PDCM,
                            CpuFeature.RESERVED,
                            CpuFeature.PCID,
                            CpuFeature.DCA,
                            CpuFeature.SSE4_1,
                            CpuFeature.SSE4_2,
                            CpuFeature.X2APIC,
                            CpuFeature.MOVBE,
                            CpuFeature.POPCNT,
                            CpuFeature.TSC_DEADLINE,
                            CpuFeature.AES,
                            CpuFeature.XSAVE,
                            CpuFeature.OSXSAVE,
                            CpuFeature.AVX,
                            CpuFeature.F16C,
                            CpuFeature.RDRAND,
                            CpuFeature.HYPERVISOR
                                              )
                                      ),

            listOf(0x7, 0x0) to mapOf(
                    GpRegister32.EBX to listOf(
                            CpuFeature.FSGSBASE,
                            CpuFeature.IA32_TSC_ADJUST,
                            CpuFeature.SGX,
                            CpuFeature.BMI1,
                            CpuFeature.HLE,
                            CpuFeature.AVX2,
                            CpuFeature.RESERVED,
                            CpuFeature.SMEP,
                            CpuFeature.BMI2,
                            CpuFeature.ERMS,
                            CpuFeature.INVPCID,
                            CpuFeature.RTM,
                            CpuFeature.PQM,
                            CpuFeature.FPU_CS_DS_DEPRECATED,
                            CpuFeature.MPX,
                            CpuFeature.PQE,
                            CpuFeature.AVX512F,
                            CpuFeature.AVX512DQ,
                            CpuFeature.RDSEED,
                            CpuFeature.ADX,
                            CpuFeature.SMAP,
                            CpuFeature.AVX512IFMA,
                            CpuFeature.PCOMMIT,
                            CpuFeature.CLFLUSHOPT,
                            CpuFeature.CLWB,
                            CpuFeature.INTEL_PT,
                            CpuFeature.AVX512PF,
                            CpuFeature.AVX512ER,
                            CpuFeature.AVX512CD,
                            CpuFeature.SHA,
                            CpuFeature.AVX512BW,
                            CpuFeature.AVX512VL
                                              ),
                    GpRegister32.ECX to listOf(
                            CpuFeature.PREFETCHWT1,
                            CpuFeature.AVX512VBMI,
                            CpuFeature.UMIP,
                            CpuFeature.PKU,
                            CpuFeature.OSPKE,
                            CpuFeature.RESERVED,
                            CpuFeature.AVX512VBMI2,
                            CpuFeature.RESERVED,
                            CpuFeature.GFNI,
                            CpuFeature.VAES,
                            CpuFeature.VPCLMULQDQ,
                            CpuFeature.AVX512VNNI,
                            CpuFeature.AVX512BITALG,
                            CpuFeature.RESERVED,
                            CpuFeature.AVX512VPOPCNTDQ,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RDPID,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.SGX_LC,
                            CpuFeature.RESERVED
                   ),

                    GpRegister32.EDX to listOf(
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.AVX512_4VNNIW,
                            CpuFeature.AVX512_4FMAPS,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED
                                              )
                                     ),
            listOf(-0x7fffffff, null) to mapOf(
                    GpRegister32.EDX to listOf(
                            CpuFeature.FPU,
                            CpuFeature.VME,
                            CpuFeature.DE,
                            CpuFeature.PSE,
                            CpuFeature.TSC,
                            CpuFeature.MSR,
                            CpuFeature.PAE,
                            CpuFeature.MCE,
                            CpuFeature.CX8,
                            CpuFeature.APIC,
                            CpuFeature.RESERVED,
                            CpuFeature.SYSCALL,
                            CpuFeature.MTRR,
                            CpuFeature.PGE,
                            CpuFeature.MCA,
                            CpuFeature.CMOV,
                            CpuFeature.PAT,
                            CpuFeature.PSE36,
                            CpuFeature.RESERVED,
                            CpuFeature.MP,
                            CpuFeature.NX,
                            CpuFeature.RESERVED,
                            CpuFeature.MMXEXT,
                            CpuFeature.MMX,
                            CpuFeature.FXSR,
                            CpuFeature.FXSR_OPT,
                            CpuFeature.PDPE1GB,
                            CpuFeature.RDTSCP,
                            CpuFeature.RESERVED,
                            CpuFeature.LM,
                            CpuFeature._3DNOWEXT,
                            CpuFeature._3DNOW
                                              ),
                    GpRegister32.ECX to listOf(
                            CpuFeature.LAHF_LM,
                            CpuFeature.CMP_LEGACY,
                            CpuFeature.SVM,
                            CpuFeature.EXTAPIC,
                            CpuFeature.CR8_LEGACY,
                            CpuFeature.ABM,
                            CpuFeature.SSE4A,
                            CpuFeature.MISALIGNSSE,
                            CpuFeature.PRFCHW,
                            CpuFeature.OSVW,
                            CpuFeature.IBS,
                            CpuFeature.XOP,
                            CpuFeature.SKINIT,
                            CpuFeature.WDT,
                            CpuFeature.RESERVED,
                            CpuFeature.LWP,
                            CpuFeature.FMA4,
                            CpuFeature.TCE,
                            CpuFeature.RESERVED,
                            CpuFeature.NODEID_MSR,
                            CpuFeature.RESERVED,
                            CpuFeature.TBM,
                            CpuFeature.TOPOEXT,
                            CpuFeature.PERFCTR_CORE,
                            CpuFeature.PERFCTR_NB,
                            CpuFeature.RESERVED,
                            CpuFeature.DBX,
                            CpuFeature.PERFTSC,
                            CpuFeature.PCX_L2I,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED,
                            CpuFeature.RESERVED
                                              )
                                              )
                                 )

    class Fields : Structure() {
        val array = intField(CPUID_MAP.size, 4)
    }

    val fields = Fields()

//    val fields = object : Structure() {
//    }

    val features by lazy {
        val buffer = ExecutableBuffer(1024)
        Assembler(buffer).emitStackFrame {
            CPUID_MAP.entries.forEachIndexed { leafIndex, (registerValues, outputRegisters) ->
                val (eaxValue, ecxValue) = registerValues
                mov(GpRegister32.EAX, eaxValue!!)

                ecxValue?.let {
                    mov(GpRegister32.ECX, it)
                }

                cpuid()

                outputRegisters.entries.forEachIndexed { flagIndex, (register, _) ->
                    val address = fields.array.getAddress(leafIndex, flagIndex)
                    mov(GpRegister64.RDI, address.value.toLong())
                    mov(AddressExpression32(GpRegister64.RDI), register)
                }
            }
        }

        buffer.execute()

        val enumSet = EnumSet.noneOf(CpuFeature::class.java)
        CPUID_MAP.entries.forEachIndexed { leafIndex, (_, outputRegisters) ->
            outputRegisters.entries.forEachIndexed { flagIndex, (_, flags) ->
                val value = fields.array[leafIndex, flagIndex]

                flags.forEachIndexed { index, flag ->
                    if (value.and(1.shl(index)) != 0) {
                        enumSet.add(flag)
                    } else {
//                        println("Missing support for $flag")
                    }
                }
            }
        }

        enumSet
    }
}