package util;

import module.Module;
import module.required.memory.Memory;
import module.required.memory.Ram;

import java.lang.reflect.Field;
import java.util.List;

public class MyUtils {
  public static boolean isNullCheck(Object object) {
    return object == null;
  }

  /**
   * @param module    꼽을 모듈 (ex : ram)
   * @param fieldName 모듈이 들어갈 필드명
   * @param target    꼽을 대상 (ex : mainboard)
   * @param <T>
   * @return 장착 성공/실패 여부 (ex : 포트가 가득 찬 상태에서 장착을 시도하면 실패한다.)
   * @throws Exception
   */
  public static <T> boolean pushModule(T module, String fieldName, Module target) throws Exception {
    Field field = getField(fieldName, target);
    System.out.println("-------------------------------------------");
    System.out.println(fieldName + "를 장착합니다.");

    if (isPushModuleAble(field, target)) {
      field.set(target, module);
      System.out.println(fieldName + "를 장착했습니다. " + fieldName + " : " + module);
      System.out.println("-------------------------------------------");
      return true;
    } else {
      System.out.println("* ERROR : 남은 슬롯이 부족합니다. 먼저 " + fieldName + "을(를) 제거해 주세요.");
      System.out.println("-------------------------------------------");
      return false;
    }
  }

  public static <T> boolean popModule(T module, String fieldName, Module target) throws Exception {
    Field field = getField(fieldName, target);
    System.out.println("-------------------------------------------");
    System.out.println(fieldName + " 장착을 해제합니다.");

    if (isPopModuleAble(module, field, target)) {
      field.set(target, null);
      System.out.println(fieldName + " 장착을 해제하였습니다. "+fieldName+" : "+module);
      System.out.println("-------------------------------------------");
      return true;
    } else {
      System.out.println("* ERROR : 해당 " + fieldName + "를 찾을 수 없습니다. "+fieldName+" : "+module);
      System.out.println("-------------------------------------------");
      return false;
    }
  }

  private static <T> boolean isPopModuleAble(T module, Field field, Module target) throws IllegalAccessException {
    Object fieldObject = getFieldObject(field, target);
    return fieldObject == module;
  }


  /**
   * 하나만 장착가능한 모듈의 장착가능 여부 확인.
   *
   * @param field
   * @param target
   * @return
   * @throws IllegalAccessException
   */
  public static boolean isPushModuleAble(Field field, Module target) throws IllegalAccessException {
    Object fieldObject = getFieldObject(field, target);
    return fieldObject == null;
  }

  /**
   * 리플렉션을 사용한 field 찾기
   *
   * @param fieldName
   * @param target
   * @return
   * @throws NoSuchFieldException
   */
  public static Field getField(String fieldName, Module target) throws NoSuchFieldException {
    Field field = target.getClass().getDeclaredField(fieldName);
    field.setAccessible(true);
    return field;
  }

  /**
   * 리플렉션을 사용한 fieldObject 찾기
   *
   * @param field
   * @param target
   * @return
   * @throws IllegalAccessException
   */
  public static Object getFieldObject(Field field, Module target) throws IllegalAccessException {
    return field.get(target);
  }

  public static double findLowestBenchScoreOfMemorys(List<Memory> Memorys){
    double LowestBenchScore = 1;
    for (Memory memory : Memorys) {
      LowestBenchScore = Math.min(memory.getBENCH_SCORE(), LowestBenchScore);
    }
    return LowestBenchScore;
  }

  public static void bootLoading(int BOOTING_GAUGE, double speed) throws InterruptedException {
    long firstTime = System.currentTimeMillis();
    for (int i = 0; i <= BOOTING_GAUGE; i++) {
      for (int j = 0; j < i; j++) {
        System.out.print("■");
      }
      for (int k = 0; k < BOOTING_GAUGE - i; k++) {
        System.out.print("□");
      }
      System.out.println();
      Thread.sleep((long) (500/speed));
    }
    long secondTime = System.currentTimeMillis();
    double difTime = (secondTime - firstTime) / (double)1000;
    System.out.println(">> 소요시간 : "+difTime+" 초");
    System.out.println("-------------------------------------------");
  }
}
