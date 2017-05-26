package jp.ac.titech.itpro.sdl.gles10ex;

import android.util.Log;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by couchpotatobv on 2017/05/26.
 */

public class Piller implements SimpleRenderer.Obj {

    private FloatBuffer vbuf;
    private float x, y, z;

    public Piller(float s, float x, float y, float z) {
        float[] vertices = {
                // back
                s, 0, -s,
                s*0.5f, s*0.866f, -s,
                -s*0.5f, s*0.866f, -s,
                -s, 0, -s,
                -s*0.5f, -s*0.866f, -s,
                s*0.5f, -s*0.866f, -s,
                // front
                s, 0, s,
                s*0.5f, s*0.866f, s,
                -s*0.5f, s*0.866f, s,
                -s, 0, s,
                -s*0.5f, -s*0.866f, s,
                s*0.5f, -s*0.866f, s,
                // side1
                s, 0, -s,
                s, 0, s,
                s*0.5f, s*0.866f, -s,
                s*0.5f, s*0.866f, s,
                // side2
                s*0.5f, s*0.866f, -s,
                s*0.5f, s*0.866f, s,
                -s*0.5f, s*0.866f, -s,
                -s*0.5f, s*0.866f, s,
                // side3
                -s*0.5f, s*0.866f, -s,
                -s*0.5f, s*0.866f, s,
                -s, 0, -s,
                -s, 0, s,
                // side4
                -s, 0, -s,
                -s, 0, s,
                -s*0.5f, -s*0.866f, -s,
                -s*0.5f, -s*0.866f, s,
                // side5
                -s*0.5f, -s*0.866f, -s,
                -s*0.5f, -s*0.866f, s,
                s*0.5f, -s*0.866f, -s,
                s*0.5f, -s*0.866f, s,
                // side6
                s*0.5f, -s*0.866f, -s,
                s*0.5f, -s*0.866f, s,
                s, 0, -s,
                s, 0, s,

        };

        vbuf = ByteBuffer.allocateDirect(vertices.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(vertices);
        vbuf.position(0);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // rear
        gl.glNormal3f(0, 0, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, 6);

        // front
        gl.glNormal3f(0, 0, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 6, 6);

        // side
        gl.glNormal3f(0.866f, 0.5f, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 12, 4);
        // top
        gl.glNormal3f(0, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 16, 4);
        // top
        gl.glNormal3f(-0.866f, 0.5f, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 20, 4);
        // top
        gl.glNormal3f(-0.866f, -0.5f, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 24, 4);
        // top
        gl.glNormal3f(0, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 28, 4);
        // top
        gl.glNormal3f(0.866f, -0.5f, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 32, 4);
    }
    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }
}