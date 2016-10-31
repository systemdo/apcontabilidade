use ap_pgraca;
 
create table if not exists meses(
idMes int(2) primary key,
nmMes varchar(20) not null 
);

create table if not exists residencias(
idResidencia int(10) primary key auto_increment,
nmResidencia varchar(20) not null 
);

create table if not exists usuarios(
idUsuario int(10) primary key auto_increment,
nmUsuario varchar(200) not null
);

create table if not exists residencias_usuarios(
idResidenciasUsuario int(10) primary key auto_increment,
idUsuario int,
idResidencia int,
foreign key(idUsuario) references usuarios(idUsuario),
foreign key(idResidencia) references residencias(idResidencia),
unique chaves_casas_usuarios(idUsuario,idResidencia)
);

create table if not exists tipos_variacao_despesa(
 idTiposVariacaoDespesa int primary key auto_increment, 
 nmTiposVariacaoDespesa varchar(150) not null
);

create table if not exists despesas_categorias(
 idDespesaCategoria int primary key auto_increment, 
 nmDespesaCategoria varchar(100) not null
);

create table if not exists despesas(
idDespesa int primary key auto_increment,  
nmDespesa varchar(200),
descricao longtext,
idUsuario int null,
idResidencia int null,
idDespesaCategoria int,
idTiposVariacaoDespesa int(2),
foreign key (idTiposVariacaoDespesa) references tipos_variacao_despesa(idTiposVariacaoDespesa),
foreign key (idDespesaCategoria) references despesas_categorias(idDespesaCategoria),
foreign key(idUsuario) references usuarios(idUsuario),
foreign key(idResidencia) references residencias(idResidencia)  
);


create table if not exists despesas_meses(
idDespesaMes int primary key auto_increment, 
idMes int,
idDespesa int, 
ano varchar(4), 
valor float(10,2), 
dtDiaInserido timestamp, 
foreign key (idMes) references meses(idMes),
foreign key (idDespesa) references despesas(idDespesa),
unique chaves_despesa_mes(idDespesa,idMes,ano) 
);


