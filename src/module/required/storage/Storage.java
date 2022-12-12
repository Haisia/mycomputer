package module.required.storage;

import module.Module;

public interface Storage extends Module {

  public void save(Object object);  // 저장
  public <T> T remove(T object);  // 삭제
  public <T> Object getObject(T key); // 확인 (HashMap 등 key 값이 숫자가 아닐 경우를 고려해서 제네릭을 사용 함.)
  public void clear();  // 포맷
}
