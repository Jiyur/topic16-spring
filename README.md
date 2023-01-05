# Đề tài : AWS Cloud9

# Yêu cầu của đề tài
- Tìm hiểu về AWS Cloud9
- Viết ứng dụng minh hoạ

## Nhóm TT 70- thành viên thực hiện:
- Trần Quang Khánh 19110376
- Phan Thanh Tài 19110452
- Bùi Văn Tính 19110478
## Các dịch vụ sử dụng
```
Amazon Cloud9
Amazon RDS
Amazon S3
Amazon Elastic BeanStalk
Amazon CloudTrail
```
## Hướng dẫn cài đặt Amazon Cloud9 
- Bước 1: Ở AWS Console, tìm kiếm dịch vụ Cloud9 trên thanh tìm kiếm
- Bước 2: Ở AWS Cloud9 Dashboard, nhấn vào "Create Environment" <br/> 
![](https://cdn.discordapp.com/attachments/1047372401803001856/1047372415753277481/image.png)
- Bước 3: Tiến hành cấu hình cài đặt cho dịch vụ như sau
![](https://cdn.discordapp.com/attachments/1047372401803001856/1047372721979412550/image.png)
![](https://cdn.discordapp.com/attachments/1047372401803001856/1047372722298171402/image.png)
![](https://cdn.discordapp.com/attachments/1047372401803001856/1047372722612731934/image.png)
- Bước 4: Sau khi hoàn thành cấu hình, nhấn vào nút "Create" để hoàn thành. Nhấn "Open" để chạy dịch vụ AWSCloud9 vừa tạo  <br/>
  ![](https://cdn.discordapp.com/attachments/1047372401803001856/1047373073151696968/image.png)
- Kết quả:   <br/>
![](https://cdn.discordapp.com/attachments/1047372401803001856/1047373633376493588/image.png)
## Hướng dẫn chạy ứng dụng minh hoạ trên AWS Cloud9
- Bước 1: Cài đặt thư viện maven để đóng gói ứng dụng bằng cách lệnh sau
```
    sudo apt update
    sudo apt install -y maven
    mvn -version (dùng để kiểm tra thư viện đã được cài hay chưa)
```
- Bước 2: Clone ứng dụng minh hoạ trên IDE Cloud9
- Bước 3: Ở trong thư mục gốc của ứng dụng vừa clone, chạy lệnh sau
```
    mvn install
```
- Bước 4: Sau khi thực hiện xong bước 3, maven sẽ đóng gói ứng dụng thành 1 file .jar. Tiếp tục thực thi các câu lệnh sau để chạy ứng dụng
```
    cd target
    java -jar <filename>.jar
```
- Bước 5: Ứng dụng chạy thành công ở PORT 3000 (Hoặc PORT khác tuỳ vào cấu hình ứng dụng). Ta có thể truy cập ứng dụng theo URL Sau:
```
    <public_host>:3000
    Trong đó: public_host chính là pulic ipv4 hoặc public DNS của máy ảo EC2 
    dùng để chạy dịch vụ AWSCloud9
```
Kết quả: Ứng dụng đã chạy thành công   <br/>

Lưu ý: nếu không thể truy cập ứng dụng qua URL trên, cần cấu hình thêm inbound rule cho máy ảo EC2 với giao thức TCP để có thể truy cập
<br/>
![](https://cdn.discordapp.com/attachments/1047372401803001856/1047374686738186290/image.png)
