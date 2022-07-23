package com.tkroman.kpi.y2022.l1

import munit.FunSuite
import Main.*

class MainSuite extends FunSuite {
    test("span on Nil"){
        val expected = None
        val actual = span(MyNil: MyList[Int], 3)
        assertEquals(actual, expected)
    }

    test("span on Cons 1"){
        val expected = MyList(MyList(1, 2), MyList(3, 4, 5))
        val actual = span(MyList(1, 2, 3, 4, 5), 3)
        assertEquals(actual, expected)
    }

   
    test("removePrefix on Nil") {
        val expected = MyNil
        val actual = removePrefix(MyNil)
        assertEquals(actual, expected)
    }
    test("removePrefix on Cons 1") {
        val expected = MyList(MyList(1))
        val actual = removePrefix(MyList(1, 2, 3), MyList(1, 2))
        assertEquals(actual, expected)
    }    
    test("removePrefix on Cons 2"){
        val expected = MyList(MyList(1, 2, 3))
        val actual = removePrefix(MyList(1, 2, 3), MyList(10, 20))
        assertEquals(actual, expected)
    }
    test("removePrefix on Cons 2"){
        val expected = MyList(MyList(1, 2, 3))
        val actual = removePrefix(MyList(1, 2, 3), MyList(5, 10))
        assertEquals(actual, expected)
    }
    test("isSubList on Nil"){
        val expected = true
        val actual = isSubList(MyList(1, 2, 3), MyList(2, 3))
        assertEquals(actual, expected)
    }
    test("isSubList on Nil"){
        val expected = true
        val actual = isSubList(MyList(1, 2, 3), MyList())
        assertEquals(actual, expected)
    }
    test("isSubList on Nil"){
        val expected = true
        val actual = isSubList(MyList(1, 2, 3), MyList(2))
        assertEquals(actual, expected)
    }
    test("isSubList on Nil"){
        val expected = false
        val actual = isSubList(MyList(1, 2, 3), MyList(3, 4))
        assertEquals(actual, expected)
    }
}
