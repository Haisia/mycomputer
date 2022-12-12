package util;

import module.Module;

import java.lang.reflect.Field;

public class MyUtils {
  public static boolean isNullCheck(Object object) {
    return object == null;
  }

  /**
   *
   * @param module 꼽을 모듈 (ex : ram)
   * @param fieldName 모듈이 들어갈 필드명
   * @param target 꼽을 대상 (ex : mainboard)
   * @return 장착 성공/실패 여부 (ex : 포트가 가득 찬 상태에서 장착을 시도하면 실패한다.)
   * @param <T>
   * @throws Exception
   */
  public static <T> boolean pushModule(T module, String fieldName, Module target) throws Exception {
    Field field = getField(fieldName, target);

    if (isPushModuleAble(field, target)) {
      field.set(target, module);
      return true;
    } else {
      System.out.println("* 실패 : 남은 슬롯이 부족합니다. 먼저 " + fieldName + "을(를) 제거해 주세요.");
      return false;
    }
  }

  /**
   * 하나만 장착가능한 모듈의 장착가능 여부 확인.
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
   * @param field
   * @param target
   * @return
   * @throws IllegalAccessException
   */
  public static Object getFieldObject(Field field, Module target) throws IllegalAccessException {
    return field.get(target);
  }


}
