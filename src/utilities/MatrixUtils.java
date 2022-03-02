package utilities;

import entity.Camera;
import entity.Transform;

public class MatrixUtils {

	public Matrix4f createTransformationMatrix(Transform transform) {
		Matrix4f transformationMatrix = new Matrix4f();
		transformationMatrix.setIdentity();
		transformationMatrix = transformationMatrix.multiply(Matrix4f.translate(transform.getPosition().x, transform.getPosition().y, transform.getPosition().z));
		transformationMatrix = transformationMatrix.multiply(Matrix4f.rotate(transform.getRotation().x, 1, 0, 0));
		transformationMatrix = transformationMatrix.multiply(Matrix4f.rotate(transform.getRotation().y, 0, 1, 0));
		transformationMatrix = transformationMatrix.multiply(Matrix4f.rotate(transform.getRotation().z, 0, 0, 1));
		transformationMatrix = transformationMatrix.multiply(Matrix4f.scale(transform.getScale().x, transform.getScale().y, transform.getScale().z));
		return transformationMatrix;
	}

	public Matrix4f createTransformationMatrix(Vector3f translation, float rx, float ry, float rz, Vector3f scale) {
		Matrix4f transformationMatrix = new Matrix4f();
		transformationMatrix.setIdentity();
		transformationMatrix = transformationMatrix.multiply(Matrix4f.translate(translation.x, translation.y, translation.z));
		transformationMatrix = transformationMatrix.multiply(Matrix4f.rotate(rx, 1, 0, 0));
		transformationMatrix = transformationMatrix.multiply(Matrix4f.rotate(ry, 0, 1, 0));
		transformationMatrix = transformationMatrix.multiply(Matrix4f.rotate(rz, 0, 0, 1));
		transformationMatrix = transformationMatrix.multiply(Matrix4f.scale(scale.x, scale.y, scale.z));
		return transformationMatrix;
	}
	
	public Matrix4f createViewMatrix(Camera camera) {
		Matrix4f viewMatrix = new Matrix4f();
	    viewMatrix.setIdentity();
	    Vector3f position = camera.getPosition();
	    Vector3f cameraPos = new Vector3f(-position.x, -position.y, -position.z);
	    Matrix4f.rotate(camera.getPitch(), new Vector3f(1,0,0), viewMatrix, viewMatrix);
	    Matrix4f.rotate(-camera.getYaw(), new Vector3f(0,1,0), viewMatrix, viewMatrix);
	    Matrix4f.translate(cameraPos, viewMatrix, viewMatrix);
	    return viewMatrix;
	}
	
}
