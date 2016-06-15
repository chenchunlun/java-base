package javassist;

import java.io.IOException;
import java.lang.reflect.*;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Created by Administrator on 2016-6-15.
 */
public class Test {
    public static void test() {
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass ctClass = classPool.get("javassist.TestJavassist");

            // 向已有对象中增加方法
            /*// System.out.println(Arrays.toString(ctClass.toBytecode()));
            System.out.println(ctClass.getName());
            System.out.println(ctClass.getSimpleName());
            System.out.println(ctClass.getSuperclass());
            System.out.println(Arrays.toString(ctClass.getInterfaces()));*/
            //CtMethod ctMethod = CtNewMethod.make("public void test(){}", ctClass);
            // 向已有对象中增加方法
           /* CtMethod m1 = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType, CtClass.intType}, ctClass);
            m1.setModifiers(Modifier.PUBLIC);
            // 占位符
            // $0 this $1、$2....第几个参数
            // $args
            m1.setBody("{System.out.println(123);return $1+$2;}");
            ctClass.addMethod(m1);

            Class cc = ctClass.toClass();
            Method method = cc.getMethod("add",int.class,int.class);
            System.out.println(method.invoke(cc.newInstance(), 200, 300));*/

            // 修改代码 方法前，方法后 指定行
            /*CtMethod m1 = ctClass.getDeclaredMethod("sayHello",new CtClass[]{CtClass.intType});
            m1.insertBefore("System.out.println(\"start\");");
            m1.insertAfter("System.out.println(\"end\");");
            m1.insertAt(8,"System.out.println(\"line 8\");");
            Class cc = ctClass.toClass();
            Method method = cc.getDeclaredMethod("sayHello",int.class);
            System.out.println(method.invoke(cc.newInstance(), 300));*/

            // 属性以及set get 方法
            /*CtField f1 = new CtField(CtClass.intType, "testField", ctClass);
            f1.setModifiers(Modifier.PRIVATE);
            ctClass.addField(f1, "1000");
            ctClass.addMethod(CtNewMethod.getter("getTestField", f1));
            ctClass.addMethod(CtNewMethod.setter("setTestField", f1));
            Class cc = ctClass.toClass();
            Object obj = cc.newInstance();
            Method m1 = cc.getDeclaredMethod("getTestField");
            System.out.println(m1.invoke(obj));
            Method m2 = cc.getDeclaredMethod("setTestField", int.class);
            m2.invoke(obj, 1);
            System.out.println(m1.invoke(obj));*/

            // 获取构造器
            /* CtConstructor[] cs = ctClass.getConstructors();
            for(CtConstructor c : cs){
                System.out.println(c);
                c.insertBefore("System.out.println(\"构造器\");");
            }
            ctClass.toClass().newInstance();*/

        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建class
     */
    public static void demo01() {
        try {
            ClassPool classPool = ClassPool.getDefault();
            CtClass cc = classPool.makeClass("Emp");
            CtField f1 = CtField.make("private int empno;", cc);
            CtField f2 = CtField.make("private String ename;", cc);
            cc.addField(f1);
            cc.addField(f2);

            CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;}", cc);
            CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", cc);
            cc.addMethod(m1);
            cc.addMethod(m2);
            CtConstructor c = new CtConstructor(new CtClass[]{CtClass.intType, classPool.get("java.lang.String")}, cc);
            c.setBody("{this.empno=empno;this.ename=ename;}");
            cc.addConstructor(c);
            cc.writeFile("D:\\IdeaProjects\\java-base\\out\\production\\java-base\\javassist");
            System.out.println();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
