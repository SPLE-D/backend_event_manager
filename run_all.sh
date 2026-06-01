#!/bin/bash

cleanup() {
    echo "Exiting script..."
    pkill -P $$
    exit 1
}

trap cleanup SIGINT

read -p "Enter the path to the frontend directory: " frontend_dir

echo "SELECT 'CREATE DATABASE eventmanager_product_notifiedeo' WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'eventmanager_product_notifiedeo') \gexec" | psql "postgresql://postgres:my-password@localhost"
for file in sql/*.sql; do
    psql -a -f "$file" "postgresql://postgres:my-password@localhost/eventmanager_product_notifiedeo"
done

java -cp eventmanager.product.notifiedeo --module-path eventmanager.product.notifiedeo -m eventmanager.product.notifiedeo &

cd $frontend_dir && {
    npm install && {
        npm run json:server &
        npm run start &
    }
}

wait