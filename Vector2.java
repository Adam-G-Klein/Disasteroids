class Vector2 {
    public float x;
    public float y;
    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public static Vector2 moveAtAngle(Vector2 initPos, float angleInDeg, float distance){
        double angleRad = Math.toRadians(angleInDeg);
        int x = (int) Math.round(initPos.x + Math.cos(angleRad) * distance);
        int y = (int) Math.round(initPos.y + Math.sin(angleRad) * distance);
        return new Vector2(x, y); 
    }
    
    public float getMagnitude(){
        return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    
    public void normalize(){
        float magnitude = getMagnitude();
        this.x = this.x / magnitude;
        this.y = this.y / magnitude;
        
    }
    
    public void add(Vector2 other){
        this.x = this.x + other.x;
        this.y = this.y + other.y;
    }
    public void sub(Vector2 other){
        this.x = this.x - other.x;
        this.y = this.y - other.y;
    }
    public void multiply(Vector2 other){
        this.x = this.x * other.x;
        this.y = this.y * other.y;
    }
    public void add(float x, float y){
        this.x = this.x + x;
        this.y = this.y + y;
    }
    
    public void multiply(float x, float y){
        this.x = this.x * x;
        this.y = this.y * y;
    }
    
    public void floorDiv(float x, float y){
        this.x = this.x / x;
        this.y = this.y / y;
    }
    
    public String toString(){
        return "vector2(" + this.x + ", " + this.y + ")";
    }
    
}
