package kleolife.data

import org.khronos.webgl.WebGLRenderingContext
import org.w3c.dom.HTMLCanvasElement

data class GraphicData(var width: Int = 500, var height:Int = 500) {
    lateinit var canvas: HTMLCanvasElement
    lateinit var ctx: WebGLRenderingContext
}
