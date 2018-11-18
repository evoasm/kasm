# Kasm

*Kasm* is a runtime assembler library for *Kotlin*.
It allows to assemble and execute machine code at runtime. 


## Features
* x86-64 up to AVX2
* Allows *save* code execution, handling segmentation faults and zero divisions etc.
* Support for automatic CPU feature detection (see `CpuId`)
* Contains a Kotlin DSL (see `Assembler`)
* Supports disassembling (through [Capstone](http://www.capstone-engine.org/))
* Full control over encoding (see `EncodingOptions`):
    - Encode with or without *SIB* (if possible)
    - Force *REX* prefix
    - Use long or short *VEX* prefix
    - Set *unused* bits in *Mod.RM*/*REX*/*VEX*
    - Legacy prefix order

## Installation

    $ git clone --recursive https://github.com/evoasm/kasm

The project does currently come without any build files. It is recommended that
you import the project into [IntelliJ IDEA](https://www.jetbrains.com/idea/).

#### Requirements
* Kotlin/JVM
* [Capstone](http://www.capstone-engine.org/) for disassembling (*optional*).
* POSIX-compliant OS (Linux and Mac OS X should both work).
* CMake (see below, *optional*)

If you want support for code execution and disassembling (through [Capstone](http://www.capstone-engine.org/))
you must build the corresponding native modules

    $ cd kasm-native/lib
    $ mkdir build
    $ cd build
    $ cmake ..

Shared libraries are output to `kasm-native/lib`. If you get a `UnsatisfiedLinkError` exception
add `-Djava.library.path=../kasm-native/lib` to your VM options.

## Examples

### `Assembler`

```kotlin

val buffer = NativeBuffer(1024)
  
Assembler(buffer).emitStackFrame {
  mov(RBX, 0)
  mov(RAX, 0)
  divRdxRax(RBX)
}
  
buffer.execute() // will throw kasm.ZeroDivisionException
```

```kotlin
Assembler(buffer).emitStackFrame {
  mov(RBX, AddressExpression(0x0))
}
  
buffer.execute() // will throw kasm.SegmentationFaultException

```

### `Instruction` 

```kotlin
val buffer = NativeBuffer(1024)
  
// add eax, [ebx]
AddR32Rm32.encode(buffer, EAX, AddressExpression32(EBX))
  
// add [ebx], eax
AddRmR32.encode(buffer, AddressExpression32(EBX), EAX)
```

### `CpuId`

```kotlin
println(CpuId.features) // [SEP, CLFSH, DS, ACPI, SSE, SSE2, SS, ...
```

### `EncodingOptions`

```kotlin
AddRm32Imm32.encode(buffer, EAX, 0x10, options = EncodingOptions(rexX = 0x0, forceRex = true))
println(buffer.toByteString()) //40 81 C0 10 00 00 00
  
AddRm32Imm32.encode(buffer, EAX, 0x10, options = EncodingOptions(rexX = 0x1, forceRex = true))
println(buffer.toByteString()) //42 81 C0 10 00 00 00
```

## License
[MPL-2.0][license]

[license]: https://github.com/evoasm/kasm/blob/master/LICENSE.txt
