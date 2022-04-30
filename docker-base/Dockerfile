FROM registry.gitlab.com/pristo/engage2022/domino-docker:V1201_11222021prod

EXPOSE 8080

USER root

#RUN yum update -y && \
RUN yum install -y nginx

COPY nginx.conf /local/nginx.conf
COPY nginx.sh /local/start.d/nginx.sh
