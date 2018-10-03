cmake_minimum_required(VERSION 3.8)

set(SOURCE_FILES
        kasm_ExecutableBuffer.c
        kasm_ExecutableBuffer.h)

add_library(kasm_buffer SHARED ${SOURCE_FILES})

