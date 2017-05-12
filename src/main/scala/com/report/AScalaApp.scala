package com.report

object AScalaApp extends App {
  println("-- scala app demo --")
  var sCls = new AScalaClass()
  var jCls = new AJavaClass()
  sCls.doSomething();
  jCls.doSomething();
}