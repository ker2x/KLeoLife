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
    val ui = UIData("KleoLife", "0.0.2-SNAPSHOT")

    // prepare index.html
    document.title = "${ui.title} - v${ui.version}"
    document.body!!.style.backgroundColor = "darkslategray"
    document.body!!.style.margin = "0px"
    document.body!!.style.padding = "0px"
    document.body!!.style.overflowX = "hidden"
    document.body!!.style.overflowY = "hidden"


    // Create canvas
    gfx.canvas = document.createElement("canvas") as HTMLCanvasElement
    gfx.ctx = gfx.canvas.getContext("webgl") as WebGLRenderingContext
    UIUtils.resizeCanvas(gfx, window.innerWidth, window.innerHeight)
    document.body!!.append(gfx.canvas)

    // add listeners
    window.onresize = { UIUtils.resizeCallback(gfx) }
    gfx.canvas.onclick = { UIUtils.mouseClickCallback(gfx, it.x, it.y) }

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

