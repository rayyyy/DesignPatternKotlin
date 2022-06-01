package dp.iterator

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class IteratorTest {
    @Test
    @DisplayName("Iterator test")
    fun one() {
        val bookShelf = BookShelf(4)
        bookShelf.appendBook(Book("1"))
        bookShelf.appendBook(Book("2"))
        bookShelf.appendBook(Book("3"))
        bookShelf.appendBook(Book("4"))

        val it = bookShelf.iterator()
        while (it.hasNext()) {
            val book = it.next()
            println(book.name)
        }
    }
}

internal class Book(var name: String) {
}

internal class BookShelf(maxsize: Int): Iterable<Book> {
    private var books: Array<Book>
    private var last: Int = 0

    init {
        this.books = Array(maxsize) { Book("") }
    }

    fun getBookAt(index: Int): Book {
        return this.books[index]
    }

    fun appendBook(book: Book) {
        this.books[last] = book
        this.last++
    }

    fun getLength(): Int {
        return this.last
    }

    override fun iterator(): Iterator<Book> {
        return BookShelfIterator(this)
    }
}

internal class BookShelfIterator(bookShelf: BookShelf): Iterator<Book> {
    private var bookShelf: BookShelf
    private var index: Int

    init {
        this.bookShelf = bookShelf
        this.index = 0
    }

    override fun hasNext(): Boolean {
        return index < bookShelf.getLength()
    }

    override fun next(): Book {
        if (!hasNext()) {
            throw java.util.NoSuchElementException()
        }

        val book: Book = this.bookShelf.getBookAt(index)
        index++
        return book
    }
}