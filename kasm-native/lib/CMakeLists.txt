cmake_minimum_required(VERSION 3.8)
project(jni C)

set(CMAKE_C_STANDARD 11)

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS}\
    -pedantic -fstrict-aliasing\
    -Wextra -Wall -Wno-unused-label -Wuninitialized\
    -Wswitch-default  -Wstrict-aliasing=3 -Wunreachable-code\
    -Wundef -Wpointer-arith -Wwrite-strings -Wconversion -Winit-self -Wno-unused-parameter")

find_package(JNI REQUIRED)
include_directories(${JNI_INCLUDE_DIRS})

set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR})

add_subdirectory(buffer)
add_subdirectory(capstone)
