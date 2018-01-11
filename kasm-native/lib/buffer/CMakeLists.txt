cmake_minimum_required(VERSION 3.8)

set(SOURCE_FILES
        kasm_NativeBuffer.c
        kasm_NativeBuffer.h)

add_library(kasm_buffer SHARED ${SOURCE_FILES})

