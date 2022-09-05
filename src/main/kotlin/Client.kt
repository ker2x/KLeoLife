import kotlinx.browser.document
import kotlinx.browser.window
import org.khronos.webgl.WebGLRenderingContext
import org.w3c.dom.HTMLCanvasElement

import kleolife.data.GraphicData
import kleolife.data.UIData
import kleolife.gl.GLUtils
import kleolife.ui.*

fun main() {
    window.onload = { setup() }
}

// setup function runs once
fun setup() {

    // Setup data class
    val gfx = GraphicData(window.innerWidth, window.innerHeight)
    val ui = UIData("KleoLife", "0.0.1-SNAPSHOT")

    // set title
    document.title = "${ui.title} - v${ui.version}"

    // body style
    document.body!!.style.backgroundColor = "darkslategray"
    document.body!!.style.margin = "0px"
    document.body!!.style.padding = "0px"
    document.body!!.style.overflowX = "hidden"
    document.body!!.style.overflowY = "hidden"

    // late init GraphicData.canvas
    gfx.canvas = document.createElement("canvas") as HTMLCanvasElement
    gfx.canvas.width = gfx.width
    gfx.canvas.height = gfx.height

    // append canvas to body
    document.body!!.append(gfx.canvas)

    // late init GraphicData.ctx
    gfx.ctx = gfx.canvas.getContext("webgl") as WebGLRenderingContext

    // add listeners
    window.onresize = { UIUtils.resize(gfx) }
    gfx.canvas.onclick = { UIUtils.mouseClick(gfx, it.x, it.y) }

    // request animation frame
    window.requestAnimationFrame { draw(gfx) }
}

// draw function runs continuously at browser refresh rate
fun draw(gfx: GraphicData) {
    // clear canvas
    GLUtils.clearScreen(gfx)

    // request next draw loop
    window.requestAnimationFrame { draw(gfx) }
}

