private float timer;
private float interval = 1f;

public ProgressBar3D progressBar3d;

public void repeat() {
    if((timer += Time.deltaTime()) >= interval) applyTest();
}

private void applyTest() {
    progressBar3d.setValue(Random.range(-10f, 120f));
    
    timer = 0f;
}

public String getComponentMenu() {
    return "Tests";
}