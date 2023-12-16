private float value = 100.0f;

@FindInChild("bar")
private SpatialObject bar;
private ProgressBarEndListener endListener;

public void start() {
    updateScale();
}

public void repeat() {
    updateScale();
}

private void updateScale() {
    // not-impl Transform.setScaleX();
    Vector3 scale = bar.getTransform().getScale();
    scale.setX(value / 100);
    
    bar.getTransform().setScale(scale);
    
    if(isEnd()) {
        callEvent();
        return;
    }
}

public void setEndListener(ProgressBarEndListener endListener) {
    this.endListener = endListener;
}

public void callEvent() {
    if(endListener == null) return;
    
    endListener.end();
}

public boolean isEnd() {
    return getValue() <= 0;
}

public void setValue(float value) {
    this.value = Math.clamp(0f, value, 100f);
}

public float getValue() {
    return this.value;
}

public String getComponentMenu() {
    return "Prototyping";
}
