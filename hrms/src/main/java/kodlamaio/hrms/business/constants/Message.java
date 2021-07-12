package kodlamaio.hrms.business.constants;


public class Message {
//	Fake Mernis	
	public static String verificationFailed = "Doğrulama başarısız oldu. Lütfen bilgilerinizi kontrol ediniz";
	
	// Register
	public static String successRegistered = "Kayıt başarıyla tamamlandı. Doğrulama kodu gönderiliyor...";
	
	
//	JobTitle
    public static String getAllJobTitle = "İş başlıkları listelendi";
    public static String getJobTitle = "İş bilgileri getirildi";
    public static String addJobTitle = "İş eklendi";
    public static String updateJobTitle = "İş güncellendi";
    public static String deleteJobTitle = "İş silindi";

// Candidate

    public static String addCandidate = "Kayıt başarıyla tamamlandı. Emailinize doğrulama kodu gönderildi...";
    public static String getAllCandidate = "Adaylar getirildi";
    public static String getNullCandidate = "Adaylar listesi boş";
    public static String updateCandidate = "Aday güncellendi";
    public static String deleteCandidate = "Aday silindi";
    public static String checkYourEmail = "Emailinizi kontrol ediniz";
    public static String emailAlreadyRegistered = "Email Zaten Kayıtlı";
    public static String identityNumberAlreadyRegistered = "TC Kimlik No Zaten Kayıtlı";
    public static String registered = "Kayıt Olundu";



//Employer
    public static String getAllEmployer = "İşverenler getirildi";
    public static String addEmployer = "İşveren eklendi";
    public static String emailVerificationFailed = "Mail adresi uzantısı ile web sitesinin alan adı uyuşmuyor";
    public static String checkNullFields = "Lütfen tüm alanları eksiksiz doldurun";
    

//Employee
    public static String addEmployee = "Çalışan eklendi";
    public static String getAllEmployee = "Çalışanlar getirildi";
    public static String getNullEmployee  = "Çalışanlar listesi boş";
    public static String updateEmployee = "Çalışan güncellendi";
    public static String deleteEmployee  = "Çalışan silindi";    
    
// Email
    
    public static String emailNotVerified = "Email doğrulanamadı";
    
//User
    public static String getAllUser = "Kullanıcılar getirildi";
    public static String getNullUser = "Kullanıcılar listesi boş";

//JobPosting
    public static String getAllJobPosting = "İş ilanları getirildi";
    public static String nullJobPosting = "İş ilanları listesi boş";
    public static String addJobPosting = "İlanınızın onaylanması bekleniyor.";
    public static String updateJobPosting = "İş ilanı güncellendi";
    public static String deleteJobPosting = "İş ilanı silindi";
    public static String getByisActiveTrue = "Tüm aktif ilanlar listelendi";
    public static String getByIsActiveTrueOrderByPostedDate = "Aktif iş ilanları tarihe göre listelendi";
    public static String getByisActiveTrueAndEmployer_companyName = "Aktif iş ilanları olan şirketler listelendi";
    public static String nullisActiveTrueAndEmployer_companyName = "Aktif iş ilanları olan şirketler listesi boş";
    public static String jobPostDoesntexists = "İş ilanı mevcut değil";
    public static String getByIsActiveTrueAndEmployer_companyName = "Şirketin iş ilanları aktif olma durumuna göre listelendi";
    public static String checkIfNullField = "Eksik bilgi girdiniz. lütfen bütün boşlukları doldurun";
	public static String getJobPosting = "İlan getirildi";
	public static String notFoundJobPosting = "İlan bulunamadı";
	public static String jobPostingIsAlreadyPassive = "İş ilanı zaten pasif";
	public static String jobPostingActived = "İş ilanı aktif hale getirildi";
	public static String checkIfEmployerEmail = "Emailiniz şirketinize ait bir domain içermelidir";
	public static String sendedActivationCode = "Aktivasyon kodu gönderildi";
	public static String verifiedActivationCode = "Hesabınız aktifleştirildi";
	
	
	
	
//
	
	
	
	
	
	
}

















