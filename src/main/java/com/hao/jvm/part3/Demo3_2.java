package com.hao.jvm.part3;

/**
 * <code>Demo3_2</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2018/3/21
 * @version: 1.0
 */
public class Demo3_2 {

}
class FinalizeEscapeGC{
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes,i am alive.");
    }

    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable{
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低,所以暂停0.5秒以等待它
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead.");
        }
        //下面这段代码与上面完全相同,但这次自救却失败了
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低,所以暂停0.5秒以等待它
        Thread.sleep(500);
        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        }else{
            System.out.println("no,i am dead.");
        }
    }

}
