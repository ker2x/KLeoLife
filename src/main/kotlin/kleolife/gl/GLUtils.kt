package kleolife.gl

import kleolife.data.GraphicData
import org.khronos.webgl.WebGLProgram
import org.khronos.webgl.WebGLRenderingContext
import org.khronos.webgl.WebGLShader

class GLUtils {
    companion object {
        fun clearScreen(gfx: GraphicData) {
            //gfx.ctx.glClearColor(0.0f, 0.0f, 0.0f, 1.0f)
            //gfx.ctx.glClear(GL_COLOR_BUFFER_BIT)
            gfx.ctx.clearColor(0.0f, 0.0f, 0.0f, 1.0f)
            gfx.ctx.clear(WebGLRenderingContext.COLOR_BUFFER_BIT)
        }

        fun createShader(gfx: GraphicData, type: Int, source: String): WebGLShader? {
            val shader = gfx.ctx.createShader(type)
            gfx.ctx.shaderSource(shader, source)
            gfx.ctx.compileShader(shader)
            return shader
        }

        fun createProgram(gfx: GraphicData, vertexShader: WebGLShader, fragmentShader: WebGLShader): WebGLProgram? {
            val program = gfx.ctx.createProgram()
            gfx.ctx.attachShader(program, vertexShader)
            gfx.ctx.attachShader(program, fragmentShader)
            gfx.ctx.linkProgram(program)
            return program
        }

    }
}

