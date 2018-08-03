<#include "*/common/header.ftlh">

<div class="col-8">
    <section id="contact">
        <div class="container">
            <div class="well well-sm">
                <h3><strong>Contact Us</strong></h3>
            </div>

            <div class="row">
                <div class="col-md-7">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2322.3833287310167!2d18.56769291587856!3d54.40320658021397!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x46fd752e661fc60f%3A0x26c57d364561b997!2sOlivia+Four%2C+aleja+Grunwaldzka+472b%2C+80-309+Gda%C5%84sk!5e0!3m2!1spl!2spl!4v1532961766377" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
                </div>
                <div class="col-md-5">
                    <h4><strong>Get in touch</strong></h4>
                    <form method="post" action="/mail-to-us">
                        <div class="form-group">
                            <input type="text" class="form-control" name="name" placeholder="Name">
                        </div>
                        <div class="form-group">
                            <input type="email" class="form-control" name="e-mail" placeholder="E-mail">
                        </div>
                        <div class="form-group">
                            <input type="tel" class="form-control" name="phone" placeholder="Phone">
                        </div>
                        <div class="form-group">
                            <textarea class="form-control" name="message" rows="3" placeholder="Message"></textarea>
                        </div>
                        <button class="btn btn-default" type="submit" name="button">
                            <i class="fa fa-paper-plane-o" aria-hidden="true"></i> Submit
                        </button>
                    </form>
                </div>
            </div>
        </div>

    </section>
</div>

<#include "*/common/footer.ftlh">