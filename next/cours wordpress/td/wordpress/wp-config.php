<?php
/**
 * La configuration de base de votre installation WordPress.
 *
 * Ce fichier contient les réglages de configuration suivants : réglages MySQL,
 * préfixe de table, clefs secrètes, langue utilisée, et ABSPATH.
 * Vous pouvez en savoir plus à leur sujet en allant sur 
 * {@link http://codex.wordpress.org/fr:Modifier_wp-config.php Modifier
 * wp-config.php}. C'est votre hébergeur qui doit vous donner vos
 * codes MySQL.
 *
 * Ce fichier est utilisé par le script de création de wp-config.php pendant
 * le processus d'installation. Vous n'avez pas à utiliser le site web, vous
 * pouvez simplement renommer ce fichier en "wp-config.php" et remplir les
 * valeurs.
 *
 * @package WordPress
 */

// ** Réglages MySQL - Votre hébergeur doit vous fournir ces informations. ** //
/** Nom de la base de données de WordPress. */
define('DB_NAME', 'mywordpress');

/** Utilisateur de la base de données MySQL. */
define('DB_USER', 'root');

/** Mot de passe de la base de données MySQL. */
define('DB_PASSWORD', '');

/** Adresse de l'hébergement MySQL. */
define('DB_HOST', 'localhost');

/** Jeu de caractères à utiliser par la base de données lors de la création des tables. */
define('DB_CHARSET', 'utf8');

/** Type de collation de la base de données. 
  * N'y touchez que si vous savez ce que vous faites. 
  */
define('DB_COLLATE', '');

/**#@+
 * Clefs uniques d'authentification et salage.
 *
 * Remplacez les valeurs par défaut par des phrases uniques !
 * Vous pouvez générer des phrases aléatoires en utilisant 
 * {@link https://api.wordpress.org/secret-key/1.1/salt/ le service de clefs secrètes de WordPress.org}.
 * Vous pouvez modifier ces phrases à n'importe quel moment, afin d'invalider tous les cookies existants.
 * Cela forcera également tous les utilisateurs à se reconnecter.
 *
 * @since 2.6.0
 */
define('AUTH_KEY',         'hK9*z;0Cqk> `urjrOB&H~:`>{uD<`O{VDg=s&:S;VDgk<=U$Fy(.(RG;fqgk/8Z');
define('SECURE_AUTH_KEY',  '@Y;M[fQbQGZ+Cti%T|Ii*r5>F&(ZtenLTd* sA N$E.G{BI_%N&.~/s]#Xg-R<*K');
define('LOGGED_IN_KEY',    ';NFgx05I%9LhOQ%Sn,uw?90#@j6?MdSoo_r@z1fj<gFUao:Vjw)FOxk+zpx+45AW');
define('NONCE_KEY',        ']9(2d}aS$n591,voY;ugG1:8x<W3?4fz{!)#Q+7)1~10(wN<yyo`<8/T&x6S~9a1');
define('AUTH_SALT',        '85Pu*t4QzfE-Sr`2Rz3FTKK<B<v?LO:>K|jD;ig>vu8B|L&`CJ&m}A8Q8&SW[*vu');
define('SECURE_AUTH_SALT', '-fUk&WVYm,|t @#]@&SnVmlT+erohV=+P]Du70~oG;w?t~,NshGTu&ZDaj om;JY');
define('LOGGED_IN_SALT',   ' <uq:_XKW,=8egX8)(hhJ[vO{D%[}XDJRJDiR`i]5xUq+X9>QWpt<Age|ahb@)+[');
define('NONCE_SALT',       '>zD4PWE;rxu;:KT_r+Nm@t-S<IEd%^V$5Ft7 K`)j 5_FE`Z|:R:!PYz6>$ N3)U');
/**#@-*/

/**
 * Préfixe de base de données pour les tables de WordPress.
 *
 * Vous pouvez installer plusieurs WordPress sur une seule base de données
 * si vous leur donnez chacune un préfixe unique. 
 * N'utilisez que des chiffres, des lettres non-accentuées, et des caractères soulignés!
 */
$table_prefix  = 'wp_';

/** 
 * Pour les développeurs : le mode deboguage de WordPress.
 * 
 * En passant la valeur suivante à "true", vous activez l'affichage des
 * notifications d'erreurs pendant votre essais.
 * Il est fortemment recommandé que les développeurs d'extensions et
 * de thèmes se servent de WP_DEBUG dans leur environnement de 
 * développement.
 */ 
define('WP_DEBUG', false); 

/* C'est tout, ne touchez pas à ce qui suit ! Bon blogging ! */

/** Chemin absolu vers le dossier de WordPress. */
if ( !defined('ABSPATH') )
	define('ABSPATH', dirname(__FILE__) . '/');

/** Réglage des variables de WordPress et de ses fichiers inclus. */
require_once(ABSPATH . 'wp-settings.php');