# Render Deployment Guide for Adaptive Learning Backend

## 🚀 Quick Deployment Summary

**Java Version:** 17  
**Build System:** Maven  
**Framework:** Spring Boot 3.2.4  
**JAR Location:** `target/adaptive-learning-backend-1.0.0.jar`  

---

## 📋 Build & Start Commands

### Build Command
```bash
mvn clean package -DskipTests -q
```

### Start Command
```bash
java -Xmx512m -Xms256m -jar target/adaptive-learning-backend-1.0.0.jar
```

---

## 🔧 Step-by-Step Deployment Guide

### Step 1: Prepare Your Repository
✅ `render.yaml` file - Already committed  
✅ `pom.xml` configured - Java 17 ready  
✅ `application.properties` - Port 8080 configured  
✅ `application-prod.properties` - Production profile added  

### Step 2: Deploy on Render

1. **Login to Render Dashboard**
   - Visit: https://dashboard.render.com
   - Sign in with GitHub or create account

2. **Create New Web Service**
   - Click "New +" button
   - Select "Web Service"
   - Choose "Build and deploy from a Git repository"

3. **Connect GitHub Repository**
   - Click "Connect" and authorize Render
   - Search for `Nageena2523/Adaptive-learning-backend`
   - Click "Connect"

4. **Configure Service Settings**
   - **Name:** `adaptive-learning-backend`
   - **Region:** `Ohio` (free tier available)
   - **Branch:** `main`
   - **Runtime:** `Java`
   - **Runtime Version:** `17`
   - **Build Command:** `mvn clean package -DskipTests -q`
   - **Start Command:** `java -Xmx512m -Xms256m -jar target/adaptive-learning-backend-1.0.0.jar`
   - **Plan:** `Free`

5. **Add Environment Variables (Optional)**
   ```
   SPRING_PROFILES_ACTIVE=prod
   JAVA_OPTS=-Xmx512m -Xms256m
   ```

6. **Deploy**
   - Click "Create Web Service"
   - Monitor deployment logs
   - Wait for ✅ "Service deployed successfully!"

---

## 🌐 Access Your Backend

Once deployed, your backend will be available at:
```
https://adaptive-learning-backend.onrender.com
```

### Test Your API
```bash
# Health check
curl https://adaptive-learning-backend.onrender.com/actuator/health

# View application info
curl https://adaptive-learning-backend.onrender.com/actuator/info
```

---

## 📝 Environment Variables Configuration

Add these to Render dashboard if needed:

```properties
# Application Profile
SPRING_PROFILES_ACTIVE=prod

# Server Configuration
SERVER_PORT=8080
SERVER_ERROR_INCLUDE_MESSAGE=always

# Logging
LOGGING_LEVEL_ROOT=INFO
LOGGING_LEVEL_COM_ADAPTIVELEARNING=INFO

# Database (if applicable)
SPRING_DATASOURCE_URL=jdbc:mysql://host:3306/dbname
SPRING_DATASOURCE_USERNAME=username
SPRING_DATASOURCE_PASSWORD=password
```

---

## 🐛 Troubleshooting

| Problem | Cause | Solution |
|---------|-------|----------|
| **Build fails** | Maven not found | Render auto-detects Java; check pom.xml syntax |
| **JAR not found** | Wrong artifact name | Verify JAR name matches: `adaptive-learning-backend-1.0.0.jar` |
| **Port binding error** | Hard-coded port in code | Use environment variable `${PORT}` or 8080 |
| **Memory error** | Heap too small | Increase `-Xmx` to 1024m (requires paid plan) |
| **Health check fails** | Missing actuator | Optional; can be disabled in Render settings |
| **Slow startup** | Cold start | Expected on free tier; improves after warm cache |
| **502 Bad Gateway** | Service crashed | Check logs in Render dashboard |

### View Deployment Logs
1. Go to Render Dashboard
2. Click on your service
3. Click "Logs" tab
4. Check build and runtime logs

---

## ✅ Pre-Deployment Checklist

- [x] Java version detected: **17**
- [x] Maven build configured: **Yes**
- [x] Start command with correct JAR: **Yes**
- [x] `render.yaml` created: **Yes**
- [x] Production profile added: **Yes**
- [x] Port configuration: **8080**
- [x] Memory limits: **512m-1024m**
- [x] Repository pushed to GitHub: **Yes**

---

## 📦 Local Testing Before Deployment

```bash
# Build locally
mvn clean package -DskipTests

# Run locally
java -jar target/adaptive-learning-backend-1.0.0.jar

# Test endpoint
curl http://localhost:8080/actuator/health
```

---

## 🔄 Auto-Deployment

- **Enabled by default** in `render.yaml`
- Every push to `main` branch triggers automatic redeployment
- Check deployment status in Render Dashboard

---

## 📚 Additional Resources

- Render Documentation: https://render.com/docs
- Spring Boot on Render: https://render.com/docs/deploy-spring-boot
- Maven Guide: https://maven.apache.org/guides/

---

## 🎯 Final API URL

```
Production Backend URL: https://adaptive-learning-backend.onrender.com

Example API Endpoints:
- GET  https://adaptive-learning-backend.onrender.com/api/users
- POST https://adaptive-learning-backend.onrender.com/api/courses
- GET  https://adaptive-learning-backend.onrender.com/health
```

---

**Need help?** Check Render dashboard logs or contact GitHub Copilot!
