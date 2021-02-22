the only open endpoint without authentication is /users POST (to create user)
endpoint /login returns token in header of the response

search endpoint with simple filter which could be extended further 
example /products/search?filter=name:Iphone11,price>599
filter structure {fieldName}{operator}{searchValue}
filter has 3 operator :(equals) >(greater) <(less)


