cmake_minimum_required(VERSION 3.8)

set(SOURCE_FILES
        kasm_Capstone.c
        kasm_Capstone.h)

find_package(PkgConfig REQUIRED)
pkg_search_module(CAPSTONE REQUIRED capstone)


if (CAPSTONE_FOUND)
    include_directories(${CAPSTONE_INCLUDE_DIRS})
    add_library(kasm_capstone SHARED ${SOURCE_FILES})
    target_link_libraries(kasm_capstone ${CAPSTONE_LIBRARIES})
    target_include_directories(kasm_capstone PUBLIC ${CAPSTONE_INCLUDE_DIRS})
endif (CAPSTONE_FOUND)


