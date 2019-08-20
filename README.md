# HZQ-Cloud

微服务开源项目架构

## 平台服务结构

- `hzq-cloud-dependencies` 通用依赖管理

- `hzq-cloud-gateway` 网关

- `hzq-cloud-registry` 注册中心

  - `registy-zk` 支持 zk 注册中心
  - `registry-nacos` 支持 nacos 注册中心

- `hzq-cloud-config` 配置中心

  - `config-nacos` 支持 nacos 配置中心

- `hzq-cloud-transaction` 分布式事务

  - `transaction-seata` 使用 seate 管理分布式事务

- `hzq-cloud-tracking` 服务链路追踪

  - `tracking-skywalking` 支持 Apache SkyWalking

- `hzq-cloud-fuse` 服务熔断

  - `fuse-sentinel` alibaba sentinel

- `hzq-cloud-limiting` 限流

  - `limiting-sentinel` alibaba sentinel

- `hzq-common` 通用组件
  发

- `hzq-cloud-generator` 代码生成

  - `mybatis-plus-generator` mybatis-plus 代码生成器

- `hzq-cloud-log` 平台日志

  - `log-api` 接口
  - `log-provider` 接口实现
  - `log-rest` rest 接口

- `hzq-system-service` 系统基础服务,

  - `system-api` 接口
  - `system-provider` 接口实现
  - `system-rest` 8080 用户相关 rest 接口

- `hzq-cloud-auth` 认证管理中心

  - `auth-service` 认证服务

- `hzq-base-service` 基础服务,用户管理, 角色管理,资源管理,字典管理

  - `base-api` 接口
  - `base-provider` 接口实现
  - `base-rest` 用户相关 rest 接口

- `hzq-manage-service` 系统服务管理,服务上架,下架

  - `manage-api` 接口
  - `manage-provider` 接口实现
  - `manage-rest` 相关 rest 接口

- `hzq-control` 服务控制，监控等
  - `hzq-monitor` 监控管理

## 项目目录结构

- dal
  entity
  mapper

# 基础错误响应中的错误码定义如下表所示：

| column1  | column2  | column3  |
| -------- | -------- | -------- |
| content1 | content2 | content3 |
