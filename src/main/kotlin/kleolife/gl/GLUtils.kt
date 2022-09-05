package kleolife.gl

import kleolife.data.GraphicData
import org.khronos.webgl.WebGLRenderingContext

class GLUtils {
    companion object {
        fun clearScreen(gfx: GraphicData) {
            //gfx.ctx.glClearColor(0.0f, 0.0f, 0.0f, 1.0f)
            //gfx.ctx.glClear(GL_COLOR_BUFFER_BIT)
            gfx.ctx.clearColor(0.0f, 0.0f, 0.0f, 1.0f)
            gfx.ctx.clear(WebGLRenderingContext.COLOR_BUFFER_BIT)
        }
    }
}

