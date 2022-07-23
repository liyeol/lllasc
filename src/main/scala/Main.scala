package com.tkroman.kpi.y2022.l1

import scala.annotation.tailrec
import scala.collection.mutable

enum MyList[+A]:
  case MyNil
  case MyCons(hd: A, tl: MyList[A])

  override def toString: String =
    @scala.annotation.tailrec
    def go(sb: StringBuilder, as: MyList[A]): String = {
      as match {
        case MyNil =>
          sb.result
        case MyCons(h, t) =>
          go(
            sb
              .append(h)
              .append(if t == MyNil then "]" else ", "),
            t
          )
      }
    }
    go(new StringBuilder("["), this)

object MyList:
  def apply[A](xs: A*): MyList[A] = of(xs*)
  def of[A](xs: A*): MyList[A] =
    xs.foldRight(MyNil: MyList[A]) { case (x, acc) => MyCons(x, acc) }

import MyList.*

def span[A] (xs: List[A], p: A => Boolean): (List[A], List[A])
val ys = xs.span(_ < 3)  


@tailrec
def removePrefix(s1: List[A], prefix: List[A]) : A = {
    def removePrefixR(l1: List[Char], l2 : List[Char]) : List[Char] = {
    
        l1 match {
        case Nil => Nil
        case x::xs => if (l2 != Nil && l2.head == x) x :: removePrefixR (xs, l2.tail) else l1
        }
    }

    removePrefixR(s1.toList, prefix.toList).mkString
}



@tailrec
def isSubList[A](xs: List[A], ys: List[A]): Boolean= {
    
    def isPrefix(pref: List[A], xs1: List[A]): Boolean = (pref,xs1) match {
    
      case (Cons(h1,t1),Cons(h2,t2)) => h1 == h2 && isPrefix(t1,t2)
      case (Nil,_) => true
      case _ => false
    
 
    xs match {
    
      case Cons(h, t) => isPrefix(xs,ys) || isSubList(t,ys)
      case _ => false

    }
  }
  
@main def run() =
  println("Hello")
  
