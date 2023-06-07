<<<<<<< HEAD
CREATE OR REPLACE TRIGGER actualizar_datos_usuario
AFTER UPDATE OF Email, Contraseña ON Usuario
FOR EACH ROW
DECLARE
    v_email_anterior Usuario.Email%TYPE;
    v_contraseña_anterior Usuario.Contraseña%TYPE;
BEGIN
    IF :NEW.Email <> :OLD.Email THEN
        utl_mail.send(sender => 'noreply@NLGJ.com',
                      recipients => :NEW.Email,
                      subject => 'Cambio de correo electrónico',
                      message => 'Se ha actualizado el correo electrónico de su cuenta.');

        INSERT INTO LogCambios (Tabla, CampoModificado, ValorAnterior, ValorNuevo, Fecha)
        VALUES ('Usuario', 'Email', :OLD.Email, :NEW.Email, SYSDATE);
    END IF;

    IF :NEW.Contraseña <> :OLD.Contraseña THEN

        INSERT INTO LogCambios (Tabla, CampoModificado, ValorAnterior, ValorNuevo, Fecha)
        VALUES ('Usuario', 'Contraseña', '********', '********', SYSDATE);
    END IF;


END;

=======
CREATE OR REPLACE TRIGGER actualizar_datos_usuario
AFTER UPDATE OF Email, Contraseña ON Usuario
FOR EACH ROW
DECLARE
    v_email_anterior Usuario.Email%TYPE;
    v_contraseña_anterior Usuario.Contraseña%TYPE;
BEGIN
    IF :NEW.Email <> :OLD.Email THEN
        utl_mail.send(sender => 'noreply@NLGJ.com',
                      recipients => :NEW.Email,
                      subject => 'Cambio de correo electrónico',
                      message => 'Se ha actualizado el correo electrónico de su cuenta.');

        INSERT INTO LogCambios (Tabla, CampoModificado, ValorAnterior, ValorNuevo, Fecha)
        VALUES ('Usuario', 'Email', :OLD.Email, :NEW.Email, SYSDATE);
    END IF;

    IF :NEW.Contraseña <> :OLD.Contraseña THEN

        INSERT INTO LogCambios (Tabla, CampoModificado, ValorAnterior, ValorNuevo, Fecha)
        VALUES ('Usuario', 'Contraseña', '********', '********', SYSDATE);
    END IF;


END;

>>>>>>> cad94b9e6445191dc056084636f89faefe73f8b5
