# 镜像打包上传
    cmd切换到项目根目录,包含dist文件夹、Dockerfile文件

    相关命令；   
    docker build -t xyz-casbin-server:1.0.2 .
    docker images -> 查询[ImageId] 97c5812f8d4f
    sudo docker tag [ImageId] registry.cn-hangzhou.aliyuncs.com/xyz/xyz-casbin-server:[镜像版本号]
        sudo docker tag 4880733c4923 registry.cn-hangzhou.aliyuncs.com/xyz/xyz-casbin-server:1.0.8
    sudo docker push registry.cn-hangzhou.aliyuncs.com/xyz/xyz-casbin-server:1.0.8