package kasm.x64

import org.junit.jupiter.api.Test
import kotlin.test.*

import java.io.File

internal class CpuIdTest {

    @Test
    fun features() {
        val features = CpuId.features
        println(features)
        println(CpuId.supportsAvx512)

        val featureNames = listOf("cx8", "cmov", "mmx", "sse", "sse2", "pclmulqdq", "ssse3", "fma", "cx16", "sse4_1")
        File("/proc/cpuinfo").let { file ->
            if(file.exists()) {
                val text = file.readText()
                val featureMap = featureNames.associateBy({it}, { "\b${it}\b".toRegex() in text })

                featureMap.forEach { key, value ->
                    assertTrue( CpuFeature.valueOf(key.toUpperCase()) in features, "mismatch for flag ${key}")
                }
            }
        }

//        :sse4_2, :movbe, :popcnt, :aes, :avx, :f16c, :rdrand, :lahf_lm, :bmi1, :avx2, :bmi2]
//
//        cpu_info_features = feature_keys.map do |feature|
//        [feature, !!(cpu_info =~ /\b#{feature}\b/)]
//        end.sort.to_h
//
//        assert_equal cpu_info_features, features.sort.select { |feature, support| feature_keys.include? feature}.to_h
    }

}