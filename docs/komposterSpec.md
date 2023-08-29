# Dokumentasi REST API Aplikasi Komposter

Dokumentasi REST API Aplikasi Komposter. API ini memungkinkan pengguna untuk mengelola data terkait suhu, kelembaban, dan pH dalam sistem komposter.

##
## Temperature

### Create Data
**Method:** POST  
**Endpoint:** `/komposter/addData/temperatures`  
**Request Body:**
```json
{
    "value": "37.3"
}
```
### Get Data
**Method:** GET     
**Endpoint:** `/komposter/data/temperatures/{id}`   
**Example:** `/komposter/data/temperatures/b6eab927-b6a1-442d-8587-15be841dea4a`

### Get All Data
**Method:** GET     
**Endpoint:** `/komposter/data/temperatures`

### Update Data
**Method:** PATCH   
**Endpoint:** `/komposter/update/temperatures/{id}`    
**Request Body:**
```json
{
    "value": "35.3"
}
```
### Delete Data
**Method:** DELETE     
**Endpoint:** `/komposter/data/temperatures/{id}`   
**Example:** `/komposter/data/temperatures/b6eab927-b6a1-442d-8587-15be841dea4a`

##
## Moisture

### Create Data
**Method:** POST  
**Endpoint:** `/komposter/addData/moistures`  
**Request Body:**
```json
{
    "value": "42.3"
}
```
### Get Data
**Method:** GET     
**Endpoint:** `/komposter/data/moistures/{id}`   
**Example:** `/komposter/data/moistures/b6eab927-b6a1-442d-8587-15be841dea4a`

### Get All Data
**Method:** GET     
**Endpoint:** `/komposter/data/moistures`

### Update Data
**Method:** PATCH   
**Endpoint:** `/komposter/update/moistures/{id}`    
**Request Body:**
```json
{
    "value": "35.3"
}
```
### Delete Data
**Method:** DELETE     
**Endpoint:** `/komposter/data/moistures/{id}`   
**Example:** `/komposter/data/moistures/b6eab927-b6a1-442d-8587-15be841dea4a`

##
## Ph-Meters

### Create Data
**Method:** POST  
**Endpoint:** `/komposter/addData/phMeters`  
**Request Body:**
```json
{
    "value": "1.3"
}
```
### Get Data
**Method:** GET     
**Endpoint:** `/komposter/data/phMeters/{id}`   
**Example:** `/komposter/data/phMeters/b6eab927-b6a1-442d-8587-15be841dea4a`

### Get All Data
**Method:** GET     
**Endpoint:** `/komposter/data/phMeters`

### Update Data
**Method:** PATCH   
**Endpoint:** `/komposter/update/phMeters/{id}`     
**Request Body:**
```json
{
    "value": "35.3"
}
```
### Delete Data
**Method:** DELETE     
**Endpoint:** `/komposter/data/phMeters/{id}`   
**Example:** `/komposter/data/phMeters/b6eab927-b6a1-442d-8587-15be841dea4a`