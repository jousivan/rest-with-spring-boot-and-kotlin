package br.com.ajss.project.unittests.mocks

import br.com.ajss.project.data.vo.v1.BooksVO
import br.com.ajss.project.model.Books

class MockBooks {

    fun mockEntityList(): ArrayList<Books> {
        val books: ArrayList<Books> = ArrayList<Books>()
        for (i in 0..13) {
            books.add(mockEntity(i))
        }
        return books
    }

    fun mockVOList(): ArrayList<BooksVO> {
        val books: ArrayList<BooksVO> = ArrayList()
        for (i in 0..13) {
            books.add(mockVO(i))
        }
        return books
    }

    fun mockEntity(number: Int) = Books(
        id = number.toLong(),
        author = "Some Author$number",
        price = 25.0,
        title = "Some Title$number"
    )

    fun mockVO(number: Int) = BooksVO(
        id = number.toLong(),
        author = "Some Author$number",
        price = 25.0,
        title = "Some Title$number"
    )
}