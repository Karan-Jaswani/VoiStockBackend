# VoiStock Backend

A Spring Boot backend application for managing inventory, invoices, and delivery challans.

## Features

- 🔐 User Authentication and Authorization
- 📊 Stock Management
- 📄 Invoice Generation
- 🚚 Delivery Challan Management
- 👤 User Profile Management
- ✉️ Email Service Integration
- 🔒 JWT Based Security

## Tech Stack

- **Framework:** Spring Boot
- **Language:** Java
- **Database:** MySQL
- **Security:** JWT (JSON Web Tokens)
- **Email Service:** Gmail SMTP
- **Build Tool:** Maven

## Prerequisites

Before running this application, make sure you have:

- Java JDK 11 or higher
- MySQL Server
- Maven
- IDE (preferably IntelliJ IDEA or Eclipse)

## Getting Started

1. **Clone the repository**
   ```bash
   git clone https://github.com/Karan-Jaswani/VoiStockBackend.git
   cd VoiStockBackend
   ```

2. **Configure Environment Variables**
   - Copy `.env.example` to `.env`
   - Update the values in `.env` with your configuration
   ```properties
   # Database Configuration
   DB_URL=jdbc:mysql://localhost:3306/your_database
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   
   # Email Configuration
   MAIL_USERNAME=your.email@gmail.com
   MAIL_PASSWORD=your_app_specific_password
   
   # JWT Configuration
   JWT_SECRET=your_jwt_secret_key_here
   ```

3. **Database Setup**
   - Create a MySQL database
   - The tables will be automatically created by Hibernate

4. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints

### Authentication
- `POST /api/auth/register` - Register new user
- `POST /api/auth/login` - User login
- `POST /api/auth/verify-otp` - Verify OTP

### Stock Management
- `GET /api/stock` - Get all stock items
- `POST /api/stock` - Add new stock item
- `PUT /api/stock/{id}` - Update stock item
- `DELETE /api/stock/{id}` - Delete stock item

### Invoice Management
- `GET /api/invoice` - Get all invoices
- `POST /api/invoice` - Create new invoice
- `GET /api/invoice/{id}` - Get specific invoice

### Delivery Challan
- `GET /api/challan` - Get all challans
- `POST /api/challan` - Create new challan
- `GET /api/challan/{id}` - Get specific challan

### Profile Management
- `GET /api/profile` - Get user profile
- `PUT /api/profile` - Update user profile

## Security

- JWT-based authentication
- Password encryption
- CORS configuration
- Environment variable based configuration
- OTP verification for sensitive operations

## Project Structure

```
src/main/java/com/Invoice/
├── Controller/          # REST API controllers
├── Models/             # Entity classes
├── Repository/         # Data access layer
├── Response/           # API response models
├── Security/           # Security configurations
└── Service/           # Business logic layer
```

## Environment Variables

| Variable | Description | Default |
|----------|-------------|---------|
| `DB_URL` | Database URL | jdbc:mysql://localhost:3306/voistock |
| `DB_USERNAME` | Database username | - |
| `DB_PASSWORD` | Database password | - |
| `MAIL_USERNAME` | Email service username | - |
| `MAIL_PASSWORD` | Email service password | - |
| `JWT_SECRET` | JWT signing key | - |
| `JWT_EXPIRATION` | JWT token expiration (ms) | 86400000 |

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Karan Jaswani - [GitHub](https://github.com/Karan-Jaswani)