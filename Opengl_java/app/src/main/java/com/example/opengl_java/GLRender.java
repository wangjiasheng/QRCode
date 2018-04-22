package com.example.opengl_java;

import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLRender implements GLSurfaceView.Renderer {
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        //告诉系统需要对透视进行修正
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT,GL10.GL_NICEST);
        //设置清理屏幕颜色
        gl.glClearColor(0,0,0,1.0f);
        //启用深度缓存
        gl.glEnable(GL10.GL_DEPTH_TEST);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        float ratio=(float) width/height;
        //设置视口(OpenGL场景的大小)
        gl.glViewport(0,0,width,height);
        //设置投影矩阵为透视矩阵
        gl.glMatrixMode(GL10.GL_PROJECTION);
        //重绘投影矩阵
        gl.glLoadIdentity();
        //创建一个透视投影举证
        gl.glFrustumf(-ratio,ratio,-1,1,1,10);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        //清理屏幕
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BITS);
        //设置模型视图矩阵
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        //重绘矩阵
        gl.glLoadIdentity();
        //视点变换
        GLU.gluLookAt(gl,0,0,3,0,0,0,0,1,0);
    }
}
