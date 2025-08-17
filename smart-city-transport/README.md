# Smart City Public Transport — Microservices Skeleton

Services:
- discovery-server (8761)
- api-gateway (8080)
- route-service (9001, Postgres)
- vehicle-tracking-service (9002, MySQL)
- ticketing-service (9003, MongoDB)
- user-service (9004, Postgres) — issues JWT
- notification-service (9005, MySQL)

## Run order
1. discovery-server
2. route-service, vehicle-tracking-service, ticketing-service, user-service, notification-service
3. api-gateway

Open Eureka: http://localhost:8761

## Gateway routes (via 8080)
- POST /auth/register
- POST /auth/login
- GET  /routes
- POST /telemetry
- POST /tickets/purchase
- POST /subscriptions

## Sample Postman
### Register
POST http://localhost:8080/auth/register
Body:
{ "email":"a@b.com", "name":"Alice", "hashedPassword":"pass" }

### Login (copy token)
POST http://localhost:8080/auth/login
{ "email":"a@b.com", "password":"pass" }

### Get routes (Bearer token required)
GET http://localhost:8080/routes
Authorization: Bearer <token>

## DBs
Update each service's application.properties with your DB credentials.
