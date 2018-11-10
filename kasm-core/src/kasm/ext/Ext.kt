package kasm.ext

import java.util.*

fun <T, C : MutableCollection<List<T>>> generatePermutations(permutations: C, permutation: MutableList<T>, collection: Collection<T>): C {
    if (permutation.size < collection.size) {
        var first = true
        for (element in collection) {
            if (element in permutation) continue

            val newPermutation = if (first) {
                permutation
            } else {
                permutation.toMutableList()
            }
            first = false
            newPermutation.add(element)
            generatePermutations(permutations, newPermutation, collection)
        }
    } else {
        permutations.add(permutation)
    }
    return permutations;
}

fun <T, C : MutableCollection<List<T>>> Collection<T>.permutationsTo(destination: C): C {
    return generatePermutations(destination, mutableListOf<T>(), this)
}


fun <T, C : MutableCollection<List<T>>> generateProducts(products: C, product: MutableList<T>, collections: List<Collection<T>>, depth: Int): C {
    if (product.size < collections.size) {
        val collection = collections[depth];
        var first = true;
        for (element in collection) {
            val newProduct = if (first) {
                product
            } else {
                product.toMutableList()
            }
            first = false
            newProduct.add(element)
            generateProducts(products, newProduct, collections, depth + 1)
        }
    } else {
        products.add(product)
    }
    return products;

}

fun <T, C : MutableCollection<List<T>>> productsTo(destination: C, collections: List<Collection<T>>): C {
    return generateProducts(destination, mutableListOf<T>(), collections, 0)
}


fun String.ifEmpty(value: String) = if(this.isEmpty()) value else this
fun <T> T?.ifNull(ifNullValue: T, elseValue: T) = if(this == null) ifNullValue else elseValue

fun Int.alignDown(alignment: Int): Int {
    return this - (this.rem(alignment))
}

fun Int.alignUp(alignment: Int): Int {
    return (this + alignment - 1).alignDown(alignment)
}

fun Long.alignDown(alignment: Int): Long {
    return this - (this.rem(alignment))
}

fun Long.alignUp(alignment: Int): Long {
    return (this + alignment - 1).alignDown(alignment)
}

@ExperimentalUnsignedTypes
fun ULong.alignDown(alignment: UInt): ULong {
    return this - (this.rem(alignment))
}

@ExperimentalUnsignedTypes
fun ULong.alignUp(alignment: UInt): ULong {
    return (this + alignment - 1UL).alignDown(alignment)
}

inline fun <reified E : Enum<E>> enumSetOf(): MutableSet<E> = EnumSet.noneOf(E::class.java)
fun <E : Enum<E>> enumSetOf(e: E): MutableSet<E> = EnumSet.of(e)
fun <E : Enum<E>> enumSetOf(e0: E, e1: E): MutableSet<E> = EnumSet.of(e0, e1)
fun <E : Enum<E>> enumSetOf(e0: E, e1: E, e2: E): MutableSet<E> = EnumSet.of(e0, e1, e2)
fun <E : Enum<E>> enumSetOf(first: E, vararg rest: E): MutableSet<E> = EnumSet.of(first, *rest)
inline fun <reified  E : Enum<E>> Collection<E>.toEnumSet(): MutableSet<E> {
    val set = enumSetOf<E>()
    forEach { set.add(it) }
    return set
}
