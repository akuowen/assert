# 异常断言公共类
```text
assert-common
├───src
│   ├───main
│   │   ├───java
│   │   │   └───club
│   │   │       └───akuo
│   │   │           └───common
│   │   │               ├───defaults    #默认实现
│   │   │               ├───exceptions  #异常
│   │   │               └───interfaces  #接口
│   │   └───resources
│   └───test
│       └───java
│           └───club
│               └───akuo
│                   └───common
│                       └───defaults    #测试用例


```

```puml
@startuml

!theme plain
top to bottom direction
skinparam linetype ortho

interface Assert << interface >> {
  + assertIsTrue(boolean): void
  + assertFail(Throwable): void
  + assertFail(): void
  + newException(Object[]): BaseException
  + assertNotNull(Object): void
  + assertIsNull(Object): void
  + assertFail(Object[]): void
  + assertIsFalse(boolean): void
  + assertEquals(Object, Object): void
  + assertNotEmpty(String, Object[]): void
  + assertIsNull(Object, Object[]): void
  + assertNotEmpty(Collection<?>, Object[]): void
  + assertNotEmpty(Map<?, ?>): void
  + assertNotEmpty(Collection<?>): void
  + assertIsFalse(boolean, Object[]): void
  + newException(Throwable, Object[]): BaseException
  + assertNotEmpty(String): void
  + assertFail(Throwable, Object[]): void
  + assertNotEmpty(Object[], Object[]): void
  + assertNotEmpty(Map<?, ?>, Object[]): void
  + assertIsTrue(boolean, Object[]): void
  + assertEquals(Object, Object, Object[]): void
  + assertNotNull(Object, Object[]): void
  + assertNotEmpty(Object[]): void
}
interface Comparable<T> << interface >> {
  + compareTo(T): int
}
interface DefaultServerExceptionAssert << interface >> {
  + newException(Object[]): BaseException
  + newException(Throwable, Object[]): BaseException
}
enum DefaultServerExceptionEnum << enumeration >> {
  + NOT_FOUND: 
  + NOT_ALLOW: 
  - message: String
  - code: Integer
  + values(): DefaultServerExceptionEnum[]
  + valueOf(String): DefaultServerExceptionEnum
  + getMessage(): String
  + getCode(): Integer
}
class Enum<E> {
  - ordinal: int
  - name: String
  + toString(): String
  - readObject(ObjectInputStream?): void
  + valueOf(Class<T>, String): T
  + equals(Object?): boolean
  # clone(): Object
  + getDeclaringClass(): Class<E>
  + hashCode(): int
  # finalize(): void
  + name(): String
  + ordinal(): int
  - readObjectNoData(): void
  + compareTo(E): int
}
interface ExceptionEnumInterface << interface >> {
  + getCode(): Integer
  + getMessage(): String
}
interface Serializable << interface >>

DefaultServerExceptionAssert  -[#008200,plain]-^  Assert                       
DefaultServerExceptionAssert  -[#008200,plain]-^  ExceptionEnumInterface       
DefaultServerExceptionEnum    -[#008200,dashed]-^  DefaultServerExceptionAssert 
DefaultServerExceptionEnum    -[#000082,plain]-^  Enum                         
Enum                          -[#008200,dashed]-^  Comparable                   
Enum                          -[#008200,dashed]-^  Serializable                 
@enduml
```

![img.png](img.png)
>public.return.api:api接口所在的包
>
> 在此包下面的返回值会自动包装 如果想忽略某个接口返回不进行包装可以添加注解 @IgnoreUnified
>

通过继承断言和Enum接口的断言枚举实现断言和异常返回
