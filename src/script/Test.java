package script;


import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
    public static void test(){
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("js");
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(Test.class.getClassLoader().getResourceAsStream("./script/javascript.js")));
            String temp = null;
            StringBuilder sb = new StringBuilder();
            while((temp = rd.readLine())!=null){
                sb.append(temp);
            }
            scriptEngine.eval(sb.toString());
            if(scriptEngine instanceof Invocable){
                Invocable invocable = (Invocable)scriptEngine;
                System.out.println(invocable.invokeFunction("test",3,-9));
            }
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        scriptEngine.put("a",3);
        scriptEngine.put("b",6);
        try {
            System.out.println(scriptEngine.eval("a+b"));
            scriptEngine.eval("var c = a*b;");
            System.out.println(scriptEngine.get("c"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}
