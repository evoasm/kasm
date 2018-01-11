package kasm.ext

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