package org.singlespaced.d3js

import org.scalajs.dom
import org.singlespaced.d3js.D3DatumObs._
import utest._

import scala.scalajs.js

object D3Test extends TestSuite {


  val elem=dom.document.createElement("p")
  dom.document.body.appendChild(elem)
  val sel=d3.selectAll("p").data(js.Array(5))

  val tests = TestSuite {
    'd3_selection_attr_fun1WithInt {
      val f= (d:Int) => d*2
      sel.attr("tabindex", f )
      assert("10" == elem.getAttribute("tabindex"))
    }
    'd3_selection_classed_fun2WithBoolean {
      val f= (d:Int,i:Int,x:Int) => d==5
      sel.classed("myclass", f )
      assert(elem.classList.contains("myclass"))
    }
    'd3_selection_attrfunx_update {
      val f3= (d:Int) => (d*2)
      val tt=sel.attr("tabindex", f3 )
    }

  }
}
