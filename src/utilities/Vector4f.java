package utilities;

import java.nio.FloatBuffer;

public class Vector4f {

    public float x;
    public float y;
    public float z;
    public float w;

    public Vector3f vector3f = new Vector3f();

    public Vector4f() {
        this.x = 0f;
        this.y = 0f;
        this.z = 0f;
        this.w = 0f;
    }
    
    public Vector4f(float x) {
        this.x = x;
        this.y = x;
        this.z = x;
        this.w = x;
    }
    
    public Vector4f(float x, float y, float z){
		this.setX(x);
		this.setY(y);
		this.setZ(z);
		this.setW(1.0f);
	}
    
    public void set(Vector4f that){
		this.setX(that.x);
		this.setY(that.y);
		this.setZ(that.z);
		this.setW(that.w);
	}
    
    public Vector3f getVec3f(){
    	vector3f.set(x, y, z);
		return vector3f;
	}
    
    public Vector4f vmul(float[] mat3x3_tri_ATA) {
    	Vector4f o = new Vector4f();
		o.x = (mat3x3_tri_ATA[0] * this.x) + (mat3x3_tri_ATA[1] * this.y) + (mat3x3_tri_ATA[2] * this.z);
		o.y = (mat3x3_tri_ATA[1] * this.x) + (mat3x3_tri_ATA[3] * this.y) + (mat3x3_tri_ATA[4] * this.z);
		o.z = (mat3x3_tri_ATA[2] * this.x) + (mat3x3_tri_ATA[4] * this.y) + (mat3x3_tri_ATA[5] * this.z);
		o.w = 0;
		return o;
	}
    
    public Vector4f mul(Vector4f r)
	{
		float w_ = w * r.w - x * r.x - y * r.y - z * r.z;
		float x_ = x * r.w + w * r.x + y * r.z - z * r.y;
		float y_ = y * r.w + w * r.y + z * r.x - x * r.z;
		float z_ = z * r.w + w * r.z + x * r.y - y * r.x;

		return new Vector4f(x_, y_, z_, w_);
	}

	public Vector4f mul(Vector3f r)
	{
		float w_ = -x * r.x - y * r.y - z * r.z;
		float x_ =  w * r.x + y * r.z - z * r.y;
		float y_ =  w * r.y + z * r.x - x * r.z;
		float z_ =  w * r.z + x * r.y - y * r.x;

		return new Vector4f(x_, y_, z_, w_);
	}
	
	public Vector4f div(float r)
	{
		float w_ = w/r;
		float x_ = x/r;
		float y_ = y/r;
		float z_ = z/r;
		return new Vector4f(x_, y_, z_, w_);
	}
	
	public Vector4f mul(float r)
	{
		float w_ = w*r;
		float x_ = x*r;
		float y_ = y*r;
		float z_ = z*r;
		return new Vector4f(x_, y_, z_, w_);
	}

    /**
     * Creates a 4-tuple vector with specified values.
     *
     * @param x x value
     * @param y y value
     * @param z z value
     * @param w w value
     */
    public Vector4f(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Calculates the squared length of the vector.
     *
     * @return Squared length of this vector
     */
    public float lengthSquared() {
        return x * x + y * y + z * z + w * w;
    }

    /**
     * Calculates the length of the vector.
     *
     * @return Length of this vector
     */
    public float length() {
        return (float) Math.sqrt(lengthSquared());
    }

    /**
     * Normalizes the vector.
     *
     * @return Normalized vector
     */
    public Vector4f normalize() {
        float length = length();
        return divide(length);
    }

    /**
     * Adds this vector to another vector.
     *
     * @param other The other vector
     *
     * @return Sum of this + other
     */
    public Vector4f add(Vector4f other) {
        float x = this.x + other.x;
        float y = this.y + other.y;
        float z = this.z + other.z;
        float w = this.w + other.w;
        return new Vector4f(x, y, z, w);
    }

    /**
     * Negates this vector.
     *
     * @return Negated vector
     */
    public Vector4f negate() {
        return scale(-1f);
    }

    /**
     * Subtracts this vector from another vector.
     *
     * @param other The other vector
     *
     * @return Difference of this - other
     */
    public Vector4f subtract(Vector4f other) {
        return this.add(other.negate());
    }

    /**
     * Multiplies a vector by a scalar.
     *
     * @param scalar Scalar to multiply
     *
     * @return Scalar product of this * scalar
     */
    public Vector4f scale(float scalar) {
        float x = this.x * scalar;
        float y = this.y * scalar;
        float z = this.z * scalar;
        float w = this.w * scalar;
        return new Vector4f(x, y, z, w);
    }

    /**
     * Divides a vector by a scalar.
     *
     * @param scalar Scalar to multiply
     *
     * @return Scalar quotient of this / scalar
     */
    public Vector4f divide(float scalar) {
        return scale(1f / scalar);
    }

    /**
     * Calculates the dot product of this vector with another vector.
     *
     * @param other The other vector
     *
     * @return Dot product of this * other
     */
    public float dot(Vector4f other) {
        return this.x * other.x + this.y * other.y + this.z * other.z + this.w * other.w;
    }

    /**
     * Calculates a linear interpolation between this vector with another
     * vector.
     *
     * @param other The other vector
     * @param alpha The alpha value, must be between 0.0 and 1.0
     *
     * @return Linear interpolated vector
     */
    public Vector4f lerp(Vector4f other, float alpha) {
        return this.scale(1f - alpha).add(other.scale(alpha));
    }

    /**
     * Stores the vector in a given Buffer.
     *
     * @param buffer The buffer to store the vector data
     */
    public void toBuffer(FloatBuffer buffer) {
        buffer.put(x).put(y).put(z).put(w);
        buffer.flip();
    }

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public void setW(float w) {
		this.w = w;
	}

}
