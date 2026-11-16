# Лаборатори 10 — Өгөгдлийн урсгалын тест

**Оюутан:** М. Билгүүн-Эрдэнэ  
**Оюутны код:** B222270046

## Хэрэгслийн хувилбар

Windows PowerShell дээр ажиллуулсан командын гаралт:

```text
> java -version
openjdk version "17.0.21.0.2" 2026-10-22 LTS
OpenJDK Runtime Environment Microsoft-15779939 (build 17.0.21.0.2+1-LTS)
OpenJDK 64-Bit Server VM Microsoft-15779939 (build 17.0.21.0.2+1-LTS, mixed mode, sharing)

> mvn -version
Apache Maven 3.10.1 (3afd8084b5629f80b97750906a719879ed4cd283)
Maven home: C:\Users\satan\Downloads\apache-maven-3.10.1-bin\apache-maven-3.10.1
Java version: 17.0.21.0.2, vendor: Microsoft, runtime: C:\Program Files\Microsoft\jdk-17.0.21.21-hotspot
Default locale: en_US, platform encoding: Cp1252, time zone: Asia/Ulaanbaatar
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```

## A — `gcd`-ийн DU хосууд

Def нь хувьсагчид утга оноох цэг, use нь тэр утгыг унших цэг юм.
Def-clear замд тухайн хувьсагчийн утга use-д хүрэхээс өмнө дахин
оноогдохгүй. `15T` ба `15F` нь `while` нөхцөлийн үнэн ба худал салаа.

| Хувьсагч | Def мөр | Use мөр | Төрөл | Def-clear зам | Тестийн ID | Хамрагдсан |
|---|---:|---|---|---|---|---|
| `x` | 13 | 16 | c-use | 13 → 15T → 16 | G2 | Тийм |
| `x` | 13 | 20 | c-use | 13 → 15F → 20 | G1 | Тийм |
| `x` | 17 | 16 | c-use | 17 → 18 → 15T → 16 | G2 | Тийм |
| `x` | 17 | 20 | c-use | 17 → 18 → 15F → 20 | G2 | Тийм |
| `y` | 13 | 15T | p-use | 13 → 15T → 16 | G2 | Тийм |
| `y` | 13 | 15F | p-use | 13 → 15F → 20 | G1 | Тийм |
| `y` | 13 | 16 | c-use | 13 → 15T → 16 | G2 | Тийм |
| `y` | 13 | 17 | c-use | 13 → 15T → 16 → 17 | G2 | Тийм |
| `y` | 18 | 15T | p-use | 18 → 15T → 16 | G2 | Тийм |
| `y` | 18 | 15F | p-use | 18 → 15F → 20 | G2 | Тийм |
| `y` | 18 | 16 | c-use | 18 → 15T → 16 | G2 | Тийм |
| `y` | 18 | 17 | c-use | 18 → 15T → 16 → 17 | G2 | Тийм |
| `tmp` | 16 | 18 | c-use | 16 → 17 → 18 | G2 | Тийм |

G1: `gcd(7, 0)` давталтад орохгүй, `7` буцаана. Зөвхөн энэ тест
анхны `x` утга 20-р мөрд хүрэх болон анхны `y` утгаар 15F салааг
сонгох хосуудыг хамарна.

G2: `gcd(12, 8)` үед `(12, 8) → (8, 4) → (4, 0)` гэж хоёр
удаа давтаад `4` буцаана. Хоёр дахь давталт нь 17, 18-р мөрд
оноосон утгууд дараагийн давталтын 16, 17-р мөрд хүрэхийг хамарна.