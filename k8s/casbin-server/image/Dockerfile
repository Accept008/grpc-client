FROM registry.cn-hangzhou.aliyuncs.com/xyz/xyz-casbin-server:1.0.1

RUN rm -rf /go/src/github.com/casbin/casbin-server/examples/rbac_model.conf
RUN rm -rf /go/src/github.com/casbin/casbin-server/examples/rbac_policy.csv

COPY data/ /go/src/github.com/casbin/casbin-server/examples/

EXPOSE 50051
