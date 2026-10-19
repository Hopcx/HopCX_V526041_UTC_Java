# Chạy chương trình HopV526041

Cần JDK 11 trở lên. Tại thư mục `demo`, chạy:

```powershell
javac -d target/classes src/main/java/com/example/demo/HopV526041.java
java -cp target/classes com.example.demo.HopV526041
```

Trong VS Code, chọn cấu hình **Chạy HopV526041** trong **Run and Debug** rồi nhấn F5.
Cấu hình này tự biên dịch và dùng đường dẫn classpath không dấu để tránh lỗi
`ClassNotFoundException` trên máy Windows có thư mục chứa ký tự tiếng Việt.

Nếu dùng Maven, chạy `mvn package` rồi `java -jar target/demo-0.0.1-SNAPSHOT.jar`.
