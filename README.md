# spring-boot-grpc-client-with-casbin-server
```text
Spring-Boot integrates GRPC to implement GRPC client and communicate with casbin-server GRPC server
```    
## IDEA config project
![](./doc/img/git-clone-status.png)
![](./doc/img/project-maven-compile.png)

## Built-in strategy
- casbin-server default built-in policy interface data
![](./doc/img/default-1.png)
![](./doc/img/default-2.png)
   
## casbin-server customize the built-in policy interface data            
![](doc/img/custom-1.png)
![](doc/img/custom-2.png)
  
## Permission validation PostMan tests

### data preparation
- model
```text
[request_definition]
r = sub, obj, act

[policy_definition]
p = sub, obj, act, eft

[policy_effect]
e = some(where (p.eft == allow)) && !some(where (p.eft == deny))

[matchers]
m = r.sub == p.sub && keyMatch(r.obj, p.obj) && keyMatch(r.act, p.act)
```
- policy
```text
p, cjc, acrn:smc:pushing:*:vod:ListMusics, pushing:ListMusics, allow
p, cjc, acrn:smc:pushing:*:vod:DescribeMusic, pushing:DescribeMusic, allow
p, cjc, acrn:smc:pushing:*:vod:CreateMusic, pushing:CreateMusic, allow
p, cjc, acrn:smc:pushing:*:vod:UpdateMusic, pushing:UpdateMusic, allow
p, cjc, acrn:smc:pushing:*:vod:DeleteMusic, pushing:UpdateMusic, allow

p, zym, acrn:smc:pushing:*:vod:ListMusics, pushing:ListMusics, allow
p, zym, acrn:smc:pushing:*:vod:DescribeMusic, pushing:DescribeMusic, allow

p, je, acrn:smc:pushing:*:vod:DescribeMusic, pushing:DescribeMusic, allow

p, david, *, *, allow

p, alice, *, List*, allow
```

### The test case
-  1.Unlogged state
 ![](./doc/img/un-login.png)
   
- 2.Casbin-server is not enabled (when server is enabled,client can access server directly without restarting)
 ![](./doc/img/casbin-server-shutdown.png)
 
- 3.1. CreateMusic
 ![](./doc/img/CreateMusic.png)
   
- 3.2. No execution permission
 ![](./doc/img/CreateMusic-WithoutPermission.png)  
 
- 4.UpdateMusic
 ![](./doc/img/UpdateMusic.png)
 
- 5.ListMusics
 ![](./doc/img/ListMusics.png)  
 
- 6.DescribeMusic
 ![](./doc/img/DescribeMusic.png)
 
- 7.DeleteMusic
 ![](./doc/img/DeleteMusic.png)
 
## Remark
```text
The PostMan interface test data is in the PostMan folder(casbin-client.postman_collection.json)
```  
 ![](./doc/img/postman-collections.png) 