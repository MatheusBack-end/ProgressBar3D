public ProgressBar3D progressBar3d;
public float perSecond = 5f;
private float timer;
private float interval = 1f;
private boolean end;

public void start() {
    progressBar3d.setEndListener(new ProgressBarEndListener() {
        public void end() {
            endTest();
        }
    });
}

public void repeat() {
    if((timer += Time.deltaTime()) >= interval) applyTest();
}

private void applyTest() {
    if(end) return;
    
    progressBar3d.setValue(progressBar3d.getValue() - perSecond);
    
    timer = 0;
}

public void endTest() {
    if(!end) {
        Console.log("T2 ok!");
        end = true;
        return;
    }
}

public String getComponentMenu() {
    return "Tests";
}